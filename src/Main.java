import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int intCount;
    static int Number;
    static int[] arrNumber;

    public static void main(String[] args) {

        File file = new File("src/arr.txt");
        try {
            Scanner countScanner = new Scanner(file);

            intCount = 0;

            while (countScanner.hasNextLine()) {

                //Считаем количество значений в файле
                int line = countScanner.nextInt();
                //System.out.println(line);

                intCount++;
            }
            countScanner.close();

            //Проверка подсчета значений
            System.out.println("Значений в файле: "+intCount);

            //Инициализация массива
            Scanner scanner = new Scanner(file);
            arrNumber = new int[intCount];
            for (int i=0; i<intCount; i++) {

                int newNumber = scanner.nextInt();
                arrNumber[i] = newNumber;
            }

            System.out.println("Исходный массив:");
            for (int j=0; j<intCount; j++)
                System.out.print(arrNumber[j]+" ");

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


            int belowCounter = 0;
            int[] arrBelowSort = new int[intCount];

            //Перенос отрицательных в начало
            for (int k=0; k<intCount; k++) {

                if (arrNumber[k]<0){
                    arrBelowSort[belowCounter]=arrNumber[k];
                    belowCounter++;
                }
            }
            //Перенос середины
            for (int k=0; k<intCount; k++) {

                if (arrNumber[k]>=0 & arrNumber[k]<=10) {
                    arrBelowSort[belowCounter] = arrNumber[k];
                    belowCounter++;
                }
            }

            //Перенос в конец больше десяти
            for (int k=0; k<intCount; k++) {

                if (arrNumber[k]>10) {
                    arrBelowSort[belowCounter] = arrNumber[k];
                    belowCounter++;
                }
            }

            //Сортировка начала и конца
            int tmp;
            for (int i = 1; i < intCount; i++) {
                for (int j = 1; j < intCount; j++) {
                    if (arrBelowSort[j] < arrBelowSort[j-1] & arrBelowSort[j]<0 & arrBelowSort[j-1]<0) {
                        tmp = arrBelowSort[j];
                        arrBelowSort[j] = arrBelowSort[j-1];
                        arrBelowSort[j-1] = tmp;
                    }

                    if (arrBelowSort[j] > arrBelowSort[j-1] & arrBelowSort[j]>10 & arrBelowSort[j-1]>10) {
                        tmp = arrBelowSort[j];
                        arrBelowSort[j] = arrBelowSort[j-1];
                        arrBelowSort[j-1] = tmp;
                    }
                }
            }

            System.out.println();
            System.out.println("Сортированный массив:");
            for (int l=0; l<intCount; l++)
                System.out.print(arrBelowSort[l]+" ");


            int mediCount = 0;
            for (int l=0; l<intCount; l++)
                if(arrBelowSort[l]>=0 & arrBelowSort[l]<=10)
                    mediCount++;

            int[] arrOfMedium = new int[mediCount];

            int med = 0;
            for (int l=0; l<intCount; l++) {
                if (arrBelowSort[l] >= 0 & arrBelowSort[l] <= 10) {
                    arrOfMedium[med] = arrBelowSort[l];
                    med++;
                }
            }

        System.out.println();
        System.out.println("Массив из средней части:");
        for (int l=0; l<mediCount; l++)
            System.out.print(arrOfMedium[l]+" ");


        }

    }

