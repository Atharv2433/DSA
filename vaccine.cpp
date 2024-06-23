#include <bits/stdc++.h>
using namespace std;

int main() {
	int t,a,b,c;
	cin>>t;
	
	while(t--){
	    cin>>a>>b>>c;
	    if(a<=c && a>=b){
	        cout<<"Take second dose now\n";
	    }
	    else {
	        if(a>c){
	            cout<<"Too Late\n";
	        }
	        else{
	            cout<<"Too Early\n";
	        }
	    }
	}

}
