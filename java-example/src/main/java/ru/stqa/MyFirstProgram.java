package ru.stqa;


public class MyFirstProgram {
    public static void main(String[] args) {
        hello("world");
        hello("Karina");
        hello("Max");


        double len = 5;
        System.out.println("Площадь квадрата со стороной " + len + " = " + area(len));

        double ax = 3;
        double bx = 2.3;
        System.out.println("Площадь прямоугольника со сторонами " + ax + " и " + bx + "=" + area(ax, bx));
        // для функции area, вызывающейся в main, мы подставляем предопределенные параметры ax и bx, которые не конфликтуют
        // с другими параметрами функции area, выполняющейся вне основной функции main (a и b). Даже если мы назовем одинаково эти параметры, ошибки не будет
    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");

        /*Переменная somebody - стала аргументом/параметром функции hello
         world - было значением переменной somebody, стало аргументом/параметром функции hello или конкретным знач-ем  функции hello
        void - ничто - функция не возвращает никакого значения
        double - тип возвращаемого значения переменной или функции с плавающей точкой
        разные функции area не конфликтуют между собой, т.к. принимают разные параметры */


    }

    public static double area (double l) {
        return l * l;
    }

    public static double area (double a, double b) {
        return a * b;
    }




}


     //   double l = 7.3;
     //   double s = l * l;
     //   System.out.println("Площадь квадрата со стороной " + l + " = " + s);






