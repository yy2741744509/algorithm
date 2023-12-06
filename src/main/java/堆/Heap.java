package 堆;

public class Heap<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] datas;
    //记录堆中元素的个数
    private int N;

    public Heap(int capacity) {
        this.datas = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    //判断堆中索引i处的元素是否小于索引j出的元素
    private boolean less(int i, int j) {
        return datas[i].compareTo(datas[j]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i, int j) {
        T temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }

    //往堆中插入一个元素
    public void insert(T t) {
        datas[++N] = t;
        swim(N);
    }

    //使用上浮算法，使索引k处的元素能在堆中处于 一个正常的位置
    private void swim(int k) {
        //通过循环不断比较当前结点和其父结点的值
        //如果父结点的值<当前结点的值,则交换位置
        while (k > 1) {
            //比较当前结点和其父结点
            if (less(k / 2, k)) {
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    //删除堆中最大的元素，并返回这个最大元素
    public T delMax() {
        T max = datas[1];

        //交换索引1处的元素与最大索引处的元素，让完全二叉树中最右侧的元素变为临时根节点
        exch(1, N);
        //最大索引处的元素删除掉
        datas[N] = null;
        //元素个数减1
        N--;
        //通过下沉排序，让堆重新有序
        sink(1);
        return max;
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k) {
        //对比当前结点k和其子结点Max(2k，2k+1)
        //如果当前结点小,则交换位置
        while (2 * k <= N) {
            //获取当前结点的子结点的较大结点
            int max;
            if (2 * k + 1 <= N) {

                max = less(2 * k, 2 * k + 1) ? 2 * k + 1 : 2 * k;


            } else {
                max = 2 * k;
            }

            //比较当前结点的子结点中的较大值
            if (!less(k, max)) {
                break;
            }

            //交换k索引处的值和max索引的值
            exch(k, max);

            //变换k的值
            k = max;
        }
    }
}
