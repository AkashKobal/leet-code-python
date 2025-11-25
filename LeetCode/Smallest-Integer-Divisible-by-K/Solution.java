for( len0=len0+1; ; len0++){// it will stop for some len0
    r=(10*r+1)%k;
    if (r==0) return len0;
}
return -1;