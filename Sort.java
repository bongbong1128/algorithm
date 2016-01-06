import java.util.*;

public class Sort{
	public static void main(String[] arg){
		Random rd = new Random();
		int N = 20;
		int [] data = new int [N];
		for (int i=0; i<N; i++)
		data[i] = rd.nextInt(N);
	
		print(data);
		long begin = System.currentTimeMillis();
		selectionSort(Arrays.copyOf(data, N));
		long end = System.currentTimeMillis();
		System.out.println("Selection Sort: " + (end-begin)/1000.0);
		begin = System.currentTimeMillis();
		bubble(Arrays.copyOf(data, N));
		end = System.currentTimeMillis();
		System.out.println("Bubble Sort: " + (end-begin)/1000.0);
		begin = System.currentTimeMillis();
		Insertion(Arrays.copyOf(data, N));
		end = System.currentTimeMillis();
		System.out.println("Insertion Sort: " + (end-begin)/1000.0);
		
		begin = System.currentTimeMillis();
		mergeSort(Arrays.copyOf(data, N),0,data.length-1);
		end = System.currentTimeMillis();
		System.out.println("mergeSort : " + (end-begin)/1000.0);
		
		
	}
	static void print(int[] number){
		for(int i=0;i<number.length;i++){
			System.out.print(number[i]+" ");
		}
		System.out.println();
	}
	static void selectionSort(int[] number){
		for(int i=number.length-1;i>=0;i--){
			int max = number[0];
			int index =0;
			for(int j=0;j<=i;j++){
				if(max < number[j]){
					max = number[j];
					index = j;
				}
			}
			int a = number[i];
			number[i] = number[index];
			number[index] = a;
		}
		print(number);
	}
	static void bubble(int[] number){
		for(int i=number.length-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(number[i]<number[j]){
					int a = number[i];
					number[i] = number[j];
					number[j] = a;
				}
			}
		}
		print(number);
	}
	static void Insertion(int[] number){
		for(int i=1;i<number.length;i++){
			int tmp = number[i];
			int index = i-1;
			while(index>=0&&number[index] >tmp){
				number[index+1] = number[index];
				index--;
			}
			number[index+1] = tmp;
			
		}
		print(number);
	}
	static void mergeSort(int[] number,int p,int r){
		if(p<r){
			int q = (p+r)/2;
			mergeSort(number,p,q);
			mergeSort(number,q+1,r);
			merge(number,p,q,r);
		}
		print(number);
	}
	static void merge(int data[],int p,int q,int r){
		int i =p,j=q+1,k=p;
		int[] tmp = new int[data.length];
		while(i<=q && j<=r){
			if(data[i]<data[j]){
				tmp[k++] = data[i++];
			}
			else{
				tmp[k++] = data[j++];
			}
		}
		while(i<=q){
			tmp[k++] = data[i++];
		}
		while(j<=r){
			tmp[k++] = data[j++];
		}
		for(int a=p;a<=r;a++){
			data[a] = tmp[a];
		}
	}
}