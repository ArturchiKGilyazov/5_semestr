public class MethodDichotomii {
    double a,b,c,d,e,del;
    int deg = 3;


    MethodDichotomii(double a_, double b_, double c_, double d_, double e_, double del_){
        this.a = a_;
        this.b = b_;
        this.c = c_;
        this.d = d_;
        this.e = e_;
        this.del = del_;

        start();
    }

    double func(double x){
        return (a*x*x*x + b*x*x + c*x + d);
    }

    double funcProisv(double x) {
        return (3*a*x*x + 2*b*x + c);
    }

    double average(double x, double y) {
        return (x + y) / 2;
    }
    double serchProisv(double a, double b) {

        double midPoint = average(a, b);
        double negPoint;
        double posPoint;
        if (funcProisv(a) < 0) {
            negPoint = a;
            posPoint = b;
        } else {
            negPoint = b;
            posPoint = a;
        }

        double testValue = funcProisv(midPoint);
        if (testValue > 0) return search(negPoint, midPoint);
        else if (testValue < 0) return search(midPoint, posPoint);
        return midPoint;

    }

    Boolean closeEnought(double x, double y) {
        return (Math.abs(x - y) < e);
    }

    double search(double a, double b) {
        double midPoint = average(a, b);
        double negPoint;
        double posPoint;
        if (func(a) < 0) {
            negPoint = a;
            posPoint = b;
        } else {
            negPoint = b;
            posPoint = a;
        }

        if (closeEnought(negPoint, posPoint)) return midPoint;
        double testValue = func(midPoint);
        if (testValue > 0) return search(negPoint, midPoint);
        else if (testValue < 0) return search(midPoint, posPoint);
        return midPoint;
    }

    void halfIntervalMethod(double a, double b) {
        double start = func(a);
        double end = func(b);
        double result;
        if (start * end < 0) {
            result = search(a, b);
            System.out.println(result);
            deg--;
        }
        else {
            if (funcProisv(a) * funcProisv(b) < 0) {
                result = serchProisv(a, b);
                if (closeEnought(func(result), 0)) {
                    System.out.println(result);
                    deg--;
                }
            }
        }
    }

    public void start() {
        long curTime = System.currentTimeMillis();
        for (int i = 0; deg > 0 && System.currentTimeMillis() - curTime < 100000; i++) {
            halfIntervalMethod(del * i, del * (i + 1));
            halfIntervalMethod(del * (i + 1), del * i);
        }
        if (deg > 0)
            System.out.println("some of answer point can be in degree or too far in infinity. Otherwise change delta");

    }
}
