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
            System.out.println("Значений: "+intCount);

            //Инициализация массива
            Scanner scanner = new Scanner(file);
            arrNumber = new int[intCount];
            for (int i=0; i<intCount; i++) {

                int newNumber = scanner.nextInt();
                arrNumber[i] = newNumber;
            }

            for (int j=0; j<intCount; j++)
                System.out.println(arrNumber[j]);

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

            System.out.println("----------");


            for (int l=0; l<intCount; l++)
                System.out.print(arrBelowSort[l]+" ");


        }

    }

