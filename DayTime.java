
package daytime;




public class DayTime {

    

    public static void main(String[] args) 
 { 
 Date d1=new Date(5,11,2005);
 Date d2=new Date(3,8,2003);
 Date d3=new Date(25,3,2015);
 Date d4=new Date(16,1,2008);
 Date d5=new Date(9,11,2025);
 Date d6=new Date(31,12,2005);
 Date d7=new Date(20,2,2000);
 Date d8=new Date(9,11,1989);
 Date d9=new Date(30,6,1994);
 Date d10=new Date(11,2,1965);
Date[] date=new Date[]{
 d1,d2,d3,d4,d5,d6,d7,d8,d9,d10
 };
 InsertionSort(date);
     for (int i = 0; i < date.length; i++) {
         System.out.println(date.length);
         
     }
 }
public static void InsertionSort(Date[]arr)
        { 
            for (int i = 1; i < arr.length; i++) {
          
            for (int j = i; j >= 1; j--) {
             if(arr[j].Year<arr[j-1].Year){
              swap(arr,j,j-1);
            
            }
            else
                 break;
            }
 }}
public static void swap(Date arr[],int ind1,int ind2)
{
Date temp = arr[ind1];
arr[ind1]=arr[ind2];
arr[ind2]=temp;

}
     
 
    
}
class Date
{ 
 int Day;
 int Mounth;
 int Year;
Date()
{Year=2000;
Mounth=01;
Day=01;
}
Date(int D,int M,int Y)
{
D=Day;
M=Mounth;
Y=Year;


}
void setDay(int Day)
{
if(Day>31)
    Day=01;
if(Day<0)
    Day=01;
this.Day=Day;
}
int getDay()
{
   return Day;
}
void setMounht(int Mounth)
{ 
if(Mounth>12)
    Mounth=01;
if(Mounth<0)
    Mounth=01;
this.Mounth=Mounth;
}
int getMounth()
{
    return Mounth;
}
void setYear(int Year)
{
if(Year<0)
    Year=2000;
this.Year=Year;
}
void AddDays(int Days){
Days=+Day;
if(Day>31)

Day=Day-31;
Mounth++;
if(Mounth>12)
    Year++;
}

void SubtractDays(int days)
{days-=Day;
if(Day<1)
   Day=31-(Day-days);
Mounth--;
if(Mounth <1)
    Year--;

}
boolean isLeapYear()
{if(Year%4==0)
    return true;
return false;

}
static int getDifference(Date d1, Date d2)
{  int diff;
   
       
        
    
        


} 
int CompareTo( Date other,Date d1){
        if(other.Year>d1.Year)
            return 1;
        if(other.Year==d1.Year||other.Mounth>d1.Mounth)
            return 1;
        if(other.Year==d1.Year||other.Mounth==d1.Mounth||other.Day>d1.Day)
            return 1;
        if(other.Year<d1.Year)
            return -1;
        if(other.Year==d1.Year||other.Mounth<d1.Mounth)
            return -1;
        if(other.Year==d1.Year||other.Mounth==d1.Mounth||other.Day<d1.Day)
            return -1;
        if(other.Year==d1.Year||other.Mounth==d1.Mounth||other.Day==d1.Day)
            return 0;
     
}
void printDate()
{
System.out.println(Day+"."+Mounth+"."+Year);
}
}
