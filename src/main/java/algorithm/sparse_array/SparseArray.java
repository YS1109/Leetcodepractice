package algorithm.sparse_array;

import java.util.Random;

public class SparseArray {
    //初始化二维数组
    public int[][] initData(int height, int width, int num) {
        Random random = new Random();
        int[][] array = new int[width][height];
        for (int i = 0; i < num; i++) {
            int currentHeight = random.nextInt(height);
            int currentWidth = random.nextInt(width);

            if (array[currentHeight][currentWidth] != 0) {
                i--;
            }
            else {
                array[currentHeight][currentWidth] = random.nextInt(2) + 1;
            }
        }
        System.out.println("初始数组为：");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    public int[][] compressArray(int[][] originArray, int num) {
        int[][] compressedArray = new int[num + 1][3];
        compressedArray[0][0] = originArray.length;
        compressedArray[0][1] = originArray[0].length;
        compressedArray[0][2] = num;
        int currentRow = 1;
        int currentOriginRow = 0;
        for (int[] array : originArray) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != 0) {
                    compressedArray[currentRow][0] = currentOriginRow;
                    compressedArray[currentRow][1] = i;
                    compressedArray[currentRow][2] = array[i];
                    currentRow++;
                }
            }
            currentOriginRow++;
        }
        System.out.println("稀疏数组为：");
        for (int[] array : compressedArray) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
        return compressedArray;
    }

    public int[][] decompressArray(int[][] compressArray) {
        int[][] decompressedArray = new int[compressArray[0][0]][compressArray[0][1]];
        for (int i = 1; i < compressArray.length; i++) {
            int[] array = compressArray[i];
            decompressedArray[array[0]][array[1]] = array[2];
        }
        System.out.println("数组还原为：");
        for (int[] array : decompressedArray) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
        return decompressedArray;
    }

    public Node compressArrayByStruct(int[][] originArray) {
        Node head = new Node();
        head.setRow(originArray.length);
        head.setCol(originArray[0].length);
        head.setValue(0);
        Node node = head;
        int currentOriginArrayRow = 0;
        for (int[] array : originArray) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != 0) {
                    Node nextNode = new Node();
                    node.setNext(nextNode);
                    nextNode.setRow(currentOriginArrayRow);
                    nextNode.setCol(i);
                    nextNode.setValue(array[i]);
                    head.setValue(head.getValue() + 1);
                    node = nextNode;
                }
            }
            currentOriginArrayRow++;
        }
        node = head;

        System.out.println("稀疏数组为：");
        while (node != null) {
            System.out.println(node.getRow() + " " + node.getCol() + " " + node.getValue());
            node = node.getNext();
        }
        return head;
    }

    public int[][] decompressArrayByStruct(Node head) {
        int[][] decompressedArray = new int[head.getRow()][head.getCol()];
        Node node = head.getNext();
        while (node != null) {
            decompressedArray[node.getRow()][node.getCol()] = node.getValue();
            node = node.getNext();
        }
        System.out.println("数组还原为：");
        for (int[] array : decompressedArray) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
        return decompressedArray;
    }

    public static void main(String[] args) {
        SparseArray sparseArray = new SparseArray();
        int[][] originArray = sparseArray.initData(10, 10, 20);
        int[][] compressArray = sparseArray.compressArray(originArray, 20);
        int[][] decompressedArray = sparseArray.decompressArray(compressArray);
        Node compressHead = sparseArray.compressArrayByStruct(originArray);
        decompressedArray = sparseArray.decompressArray(compressArray);
    }
}
