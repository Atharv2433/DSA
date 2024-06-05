#include<iostream>
using namespace std;

int fun(int i, string &s){
    int n=s.size();
    if(i>=s.size()/2)return true;

    if(s[i]!=s[n-i-1])return false;
    
    return fun(i+1,s);
}
int main(){
    string s="madam";
    cout << s << (fun(0,s) ? " is a palindrome." : " is not a palindrome.") << endl;
}