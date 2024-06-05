#include<iostream>
using namespace std;


void fun(int i,int arr[],int n){
    if(i>=n/2)
    return ;
   swap(arr[i],arr[n-i-1]);
   fun(i+1,arr,n);
}
int main(){
    int arr[100];
    int n;
    cout<<"Enter the count ";
    cin>>n;
    for(int i=0;i<n;i++){
        cout<<"Enter element "<<i+1<<" ";
        cin>>arr[i];
    }
    fun(0,arr,n);

    cout<<"Reverse array is "<<endl;
    for(int i=0;i<n;i++){
        cout<<arr[i] <<endl;
    }
}