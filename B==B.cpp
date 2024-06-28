#include <iostream>
#include<bits/stdc++.h>
using namespace std;

int main() {
	int t;
	cin>>t;
	while(t--){
	    string s,n,temp=" ";
	    cin>>s>>n;
	    
	    for(int i=0;i<s.length();i++){
	        if(s[i]==n[i]){
	            temp+='G';
	        }
	        else{
	            temp+='B';
	        }
	    }
	    cout<<temp<<endl;
	}
	return 0;
}
