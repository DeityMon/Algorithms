package wilburhsu.CodingInterview;

public class _38_NumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int len = array.length;
        if(len == 0)
            return 0;
        int start = getFirst(array,0,len-1,k);
        int end = getLast(array,0,len-1,k);
        if(start != -1 && end != -1)
            return end - start + 1;
        return 0;
    }

    public int getFirst(int[] array,int start,int end,int k){
        int mid;
        while(start <= end){
            mid = start + (end - start)/2;
            if(k <= array[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        if(start < array.length && array[start] == k)
            return start;
        else
            return -1;
    }

    public int getLast(int[] array,int start,int end,int k){
        int mid;
        while(start <= end){
            mid = start + (end - start)/2;
            if(k >= array[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        if(end >= 0 && array[end] == k)
            return end;
        else
            return -1;
    }

    public int getFirstK(int[] array,int start,int end,int k){
        int mid;
        while(start <= end){
            mid = start + (end - start)/2;
            if(k < array[mid])
                end = mid - 1;
            else if (k > array[mid])
                start  = mid +1;
            else {// 找到了k值所在的位置，k == array[mid]
                if((mid > 0 && array[mid - 1] != k ) || mid == 0)
                    return mid;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public int getLastK(int[] array,int start,int end,int k){
        int mid;
        while (start <= end){
            mid = start + (end - start)/2;
            if(k < array[mid])
                end = mid - 1;
            else if(k > array[mid])
                start = mid + 1;
            else {
                if((mid < array.length - 1 && array[mid + 1] != k )|| mid == array.length - 1)
                    return mid;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array1 = {1,3,9,9,9,9,9,9,13,14};
        int[] array2 = {1,2,3,3,3,3};
        _38_NumberOfK numberOfK = new _38_NumberOfK();
        System.out.println(numberOfK.GetNumberOfK(array1,9));
        System.out.println(numberOfK.GetNumberOfK(array2,3));
    }
}


