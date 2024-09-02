Class String_1{
    long long n,x,y;
    string s;

    cin>>n>>x>>y;
    cin>>s;

    long long a,b;

    for(int i =1;i<n;i++){
        if(s[i-1] == 'U') b++;
        else if(s[i-1] == 'D') b--;
        else if(s[i-1] == 'L') a--;
        else if(s[i-1] == 'R') a++;

        long long d = abs(x-a) + abs(y-b);
        if(d <= i && d % i == i % 2 ){
            return "YES"
        }
    }
    return "NO";

}