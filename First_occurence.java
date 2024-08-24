public class First_occurence{
    public static int get_index(int arr[] , int key,int index){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == key){
            return index;
        }
        return get_index(arr,key,index+1);
    }

    public static int last_occrurence(int arr[],int key,int i){
        if( i == arr.length){
            return -1;
        }
        int is_found = last_occrurence(arr, key, i+1);
        if(is_found == -1 && arr[i] == key){
            return i;
        }
        return is_found;
    }
    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6,1,2,3};
        int key =3;
        int index= 0;
        System.out.println(get_index(arr,key,index));
        System.out.println(last_occrurence(arr,key,index));
    }
}