// Proceed the loop in the most significant digit first order
for( int t=T; t>=1; num%=t, t/=10){
    const int d=num/t;// find the current digit

    if (!seeA && d!=9){// if a is not seen and uneqal to 9
        a=d;// set a=d
        seeA=1; // mark a is seen
        x+=9*t; // add 9*t to x as max
    }
    else if (seeA && d==a)  // if a is seen and d==a
        x+=9*t; // add 9*t to x as max
    else x+=d*t; // d!=a just add d*t  to x as max
    if (!seeB && d!=0){// if b is not seen and d!=0
        b=d;// set b=d
        seeB=1; // mark b is seen
    }
    else if (d!=b) // if d!=b
        y+=d*t; // just add d*t to y as min
}