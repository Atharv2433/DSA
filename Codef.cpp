#include<bits>
using namespace std;

int main(){

    int t =0;
    cin>>t;
    while(t--){
        int total_fruits_n;
        int capacity_per_sec_x;
        int can_put_y;
        cin>>total_fruits_n>>capacity_per_sec_x>>can_put_y;

        int m = min(capacity_per_sec_x,can_put_y);

        cout<<(total_fruits_n + m - 1)/m<<endl;
    
    }
    return 0;
}