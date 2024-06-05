#include<iostream>
using namespace std;

void fun(int i,int n){
    if(i>n){
        return;
    }
    else{
        cout<<"NAME";
    }
    fun(i+1,n);
}
int main(){
    int n;
    cout<<"Enter the count to print name how many times ";
    cin>>n;
    fun(1,n);
}