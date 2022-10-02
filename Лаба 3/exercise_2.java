public class exercise_2 {
    public static void main(String[] args) {
        System.out.println("Задание №2");
        Integer n2 = (20 * 30 * 10) + (20 * 3);

        Double k = calcStructParam(n2.doubleValue());
        System.out.println("Структурные параметры(K): " + k.intValue());

        Double n = calcLengthProgram(k);
        System.out.println("Длина программы(N): " + n.intValue());

        Double v = calcProgramScope(k);
        System.out.println("Объем программного обеспечения(V): " + v.intValue());

        Double p = calcAssemblerInstruction(n);
        System.out.println("Количество комманд ассемблера(P): " + p.intValue());

        Double t = calcCalendarProgramming(n, 3, 15);
        System.out.println("Календарное время программированя(T): " + t.intValue());

        Double b = calcNumberErrors(v);
        System.out.println("Расчет потенциального количества ошибок(B): " + b.intValue());

        Double tn = calcSoftwareReliability(t, b);
        System.out.println("Расчёт начальной надежности: " + tn.intValue());

    }
    //Потенциальный объем программы (V)
    public static Double calcProgramScope(int n){
        return (n + 2) * (Math.log(n + 2) / Math.log(2));
    }
    //Потенциальное число ошибок (B)
    public static Double calcNumberErrors(double v, double a){
        return Math.pow(v, 2) / (3000 * a);
    }

    //расчет структурных параметров (K)
    public static Double calcStructParam(Double n){
        if ( (n / 8) > 8)
            return (n / 8) + (n / (Math.pow(8, 2)));
        else
            return n / 8;
    }

    //Расчет длины программы (N)
    public static Double calcLengthProgram(Double k){
        return (220 * k) + k * (Math.log(k) / Math.log(2));
    }

    //Расчет объема программного обеспечения (V)
    public static Double calcProgramScope(Double k){
        return k * 220 * (Math.log(48) / Math.log(2));
    }

    //Расчет количества команд ассемблера (P)
    public static Double calcAssemblerInstruction(Double n){
        return (3 * n) / 8;
    }

    //Расчет календарного времени программирования(T)
    public static Double calcCalendarProgramming(Double n, Integer m, Integer v){
        return (3 * n) / (8 * m * v);
    }

    //Расчет потенциального количества ошибок(B2)
    public static Double calcNumberErrors(Double v){
        return  v / 3000;
    }

    //Расчет начальной надёжности ПО
    public static Double calcSoftwareReliability(Double t, Double b){
        return (t * 8) / (2 * Math.log(b));
    }
}

