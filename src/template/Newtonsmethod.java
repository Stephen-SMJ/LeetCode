package template;

public class Newtonsmethod {
    /*
    牛顿法：
    1.写要求的函数表达式f如，平方为x*x,三次方为x*x*x
    2.求导数df
    3.while df > 阈值
    4.next = current - sq/dsq
    5.current = next

    def newton_method(ini_root， epison):
	# 方程 f(x)
	def f(x):
		pass

	# f(x) 的导函数
	def df(x):
		pass

	cur_root = ini_root # 初始迭代值，可以任意选取

	# epison 为精度
	while abs(f(cur_root )) > epison:
		nxt_root = cur_root - f(cur_root ) / df(cur_root )
		cur_root  = nxt_root

	return cur_root
     */
    //需要求解的方程
    public static double f(double x, double t) {
        return Math.abs(x * x - t); // x*x=t x*x-t=0. 迭代使得这个函数趋于0
    }
    //导数
    public static double df(double x) {
        return 2 * x;
    }
    public static double newtonMethod1(int root, double epison){
        int t = root; //记录值，计算上面的f

        double cur_root = root; // 初始迭代值，可以任意选取

        while (f(cur_root,t) > epison){
            double nxt_root = cur_root - f(cur_root,t) / df(cur_root);
            cur_root  = nxt_root;
        }
        return (int)cur_root;
    }

    public static double newtonMethod2(int num, double e) {
        double root = num;
        double x0 = num;
        double x1 = 0;
        while (Math.abs(f(x0,root))>e) {
            x1 = x0 - (f(x0, root) / df(x0));
            x0 = x1;
        }
        return x0;
        //保留n为小数 return String.format("%.2f",x1);

    }

    public static void main(String[] args) {
        System.out.println(Newtonsmethod.newtonMethod2(9,Math.pow(10,-4)));
    }

}

