
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> sw = new ArrayList<Integer>() {{
            add(5);
            add(7);
            add(9);
            add(11);
        }};
        List<Integer> swWithErrors = new ArrayList<Integer>() {{
            add(0);
            add(2);
            add(5);
            add(4);
        }};
        double lambda = 1.53;
        // Вычисляем для трех вариантов коэффициентов
        // (адекватный результат получается только для третьего варианта)
        for (int i = 1; i <= 3; ++i) {
            double R = calcRating(sw, swWithErrors, lambda, i);
            System.out.println("Рейтинг для варианта коэффициента " + i + ":");
            System.out.println(String.format("%.4f", R));
            // Вычисляем ожидаемое число ошибок
            int nextB = (int)(getCoef(lambda, R, i) * 15);
            System.out.println("Ожидаемое число ошибок в следующей программе объемом 15 Кб: ");
            System.out.println(String.format("%d шт.", nextB));
        }
    }

    // Вычисление коэффициента c(lambda_k, Rk), рассматриваем три варианта
    public static double getCoef(double lambda, double Rk, int var) {
        switch (var) {
            case 1: {
                return 1.0 / (lambda + Rk);
            }
            case 2: {
                return 1.0 / (lambda * Rk);
            }
            case 3: {
                return 1.0 / lambda + 1.0 / Rk;
            }
            default: return 0;
        }
    }

    // Рейтинг в i-й момент времени
    // i = sw.size(), т.к. для n написанных программ можно вычислить рейтинг в n-ый момент времени
    // размер swWithErrors предполагается таким же, т.е. по каждой программе есть данные о количестве ошибок в ней
    public static Double calcRating(List<Integer> sw, List<Integer> swWithErrors, double lambda, int var) {
        int i = sw == null ? 0 : sw.size();

        // Базовый случай при i = 0: R0 = 1000
        if (i == 0) return 1000.0;

        // Рекурсивный вызов: вычисляем предыдущий рейтинг
        // списки программ и ошибок в них сокращаются на 1 элемент
        double prevR = calcRating(sw.subList(0, i - 1), swWithErrors.subList(0, i - 1), lambda, var);

        // Сумма объемов программ
        Integer vSum = sw.stream().reduce(0, Integer::sum);

        // Сумма ошибок с коэффициентом c
        double bSum = 0;
        for (int k = 1; k <= i; k++) {
            double bk = swWithErrors.get(k - 1); // количество ошибок
            // Получаем коэффициент c, для его вычисления используем вычисленный по рекурсивной формуле рейтинг
            // в момент времени k - 1
            double c = getCoef(
                    lambda,
                    calcRating(sw.subList(0, k - 1), swWithErrors.subList(0, k - 1), lambda, var),
                    var
            );
            bSum += bk / c;
        }

        // Окончательно вычисляем рейтинг по формуле
        return prevR * (1.0 + 1E-3 * (vSum - bSum));
    }

}
