#include<string.h>
#include<stdio.h>
int main()
{
char str[10];
char q;
char beta[100]={"0"};
int k = 4,i=0;
char str1[200];
int len = 0,exp = 0;
char A;
int m = 0;
char buffer[500];
clrscr();
printf("Enter the no.of expression\n");
scanf("%d",&exp);
while(exp--){
printf("Enter the string %d\n",m+1);
scanf("\n%[^\n]",&str);
 for (i = 0; str[i] != '\0'; i++)
 {
len++;
 }
A = str[0];
//printf("%d",len);
// token = strtok(str,"->");
// printf("%s\n",token);
//printf("%c",faltu);
if(str[0]==str[3])
{
 q = '|';
i=0;
while(str[k]!=q)
{
	
	
str1[i]=str[k];
k=k+1;
i=i+1;

}
k++;
//printf("%s",str);
i=0;
//char buf[500] = {"\0"};

while(k < len){
	 if(str[k]==q){
	
             beta[i++] = A;
             
             beta[i++] = 39;
             
             //printf("%s\n",beta);
           
	}
	
 beta[i] = str[k];
 k++;
 i++;

}
//strcat(beta,"\0");
//beta[length+1] = "\0";
//printf("%s",beta);
//printf("%s",str1);
printf("\n%c->%s",A,beta);
printf("%c'\n\0",A);
sprintf(buffer,"%c'->%s%c'%cepsilon\0",A,str1,A,q);
printf("\n%s\0",buffer);
}
else{
printf("%s\n",str);
}
m++;
}

return 0;
}