public class exercise_1 {
    public static void main(String[] args) {
        System.out.println("Задание №1");
        Double a = 1.53;
        Integer n2 = (20 * 30 * 10) + (20 * 3);

        System.out.println("Уровень языка программирования(a): " + a);
        System.out.println("Минимальное число различных операндов(n): " + n2);

        Double v = calcProgramScope(n2);
        System.out.println("Потенциальный объем программы(V): " +v.intValue());

        Double b = calcNumberErrors(v, a);
        System.out.println("Потенциальное число ощибок(B): " + b.intValue());


    }
    //Потенциальный объем программы (V)
    public static Double calcProgramScope(int n){
        return (n + 2) * (Math.log(n + 2) / Math.log(2));
    }
    //Потенциальное число ошибок (B)
    public static Double calcNumberErrors(double v, double a){
        return Math.pow(v, 2) / (3000 * a);
    }


}

