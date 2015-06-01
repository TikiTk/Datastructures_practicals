
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Huffman {
    
    public static class DNode {
    private DNode next;
    private DNode prev;
    private String data;
    private int freq;

    public DNode() {}
    
    public DNode(DNode next,DNode prev,String data,int freq){
        this.next=next;
        this.prev=prev;
        this.data=data;
        this.freq=freq;}
    
   public DNode(String data, int freq){
       this.data=data;
       this.freq=freq;}
   
    public DNode getNext() {
        return next;}

    public void setNext(DNode next) {
        this.next = next;}

    public DNode getPrev() {
        return prev;}

    public void setPrev(DNode prev) {
        this.prev = prev;}

    public String getData() {
        return data;}

    public void setData(String data) {
        this.data = data;}

    public int getFreq() {
        return freq;}

    public void setFreq(int freq) {
        this.freq = freq;}}
    
    public static class DLinkedList {
    private DNode head;
    private int size;
    private int heapSize;

    public int getSize() {
        return size;}
    
    public DLinkedList() {
        this.head = new DNode(null, null, "", 0);
        this.size = 0;}

    public boolean isEmpty() {
        return size == 0;}

    public void addHead(String tmp, int num) {
        if (isEmpty()) {
            DNode tmpNode = new DNode(null, head, tmp, num);
            head.setNext(tmpNode);} 
        else {
            DNode oriNode = head.getNext();
            DNode tmpNode = new DNode(oriNode, head, tmp, num);
            head.setNext(tmpNode);
            oriNode.setPrev(tmpNode);}
        size++;}

    public DNode removeHead() {
        DNode tmpNode = head.getNext();
        head = head.getNext();
        size--;
        return tmpNode;}

    public void insertAtTail(String tmp, int num) {
        if (isEmpty()) {
            addHead(tmp,num);
            return;} 
        else {
            DNode pos = head;
            for (int i = 0; i < size; i++) {
                pos = pos.getNext();}
            DNode tmpNode = new DNode(null, pos, tmp, num);
            pos.setNext(tmpNode);}
        size++;}
    
    public void buildMinHeap(){
        heapSize=size-1;
        for (int i = heapSize/ 2; i >= 0; i--) {
            minheap(i);}}
     
    public void minheap(int i) {
       int left = 2 * i;
       int right = 2 * i + 1;
       int largest = i;
    
        DNode nodeLargest=nodeAtIndex(largest);
        if(left <= heapSize){
            DNode nodeLeft=nodeAtIndex(left);//arr[left]
            if (nodeLeft.getFreq() < nodeLargest.getFreq()) {
                largest = left;
                nodeLargest=nodeAtIndex(largest);}}
        
        if(right <= heapSize){
                DNode nodeRight=nodeAtIndex(right);
            if (nodeRight.getFreq() < nodeLargest.getFreq()) {
                 largest = right;
                 nodeLargest=nodeAtIndex(largest);}}
        
        if (largest != i) {
            swap(largest,i);
            minheap(largest);}}
    
    //swap index a with index b
    public void swap(int a, int b){
        
        DNode nodeA = nodeAtIndex(a);
        DNode nodeB = nodeAtIndex(b);
        
        String ele = nodeA.getData();
        int freq = nodeA.getFreq();
        
        nodeA.setData(nodeB.getData());
        nodeA.setFreq(nodeB.getFreq());
        nodeB.setData(ele); 
        nodeB.setFreq(freq);}
    
    public DNode nodeAtIndex(int i){
        DNode pos = head;
         for(int n=0;n<=i;n++){
            pos=pos.getNext();}
        return pos;}
    
    public String nodeAtmyIndex(int i){
        
        DNode pos = head.getNext();
            for(int n=0;n<size;n++){
                if(i==pos.getFreq()){
                if(pos.getData().length()==1){
                     return pos.getData();}}
        pos=pos.getNext();}
        return "";}
    
    public void print() {
        DNode pos = head.getNext();
        for (int i = 0; i <size; i++) {
            System.out.println("index: " + i + "value: " + pos.getData() + ":" + pos.getFreq());
            pos = pos.getNext();}}
    
    public String find(String num){
        DNode pos=head;
        String strVal="";
        for(int i=0;i<=size;i++){
            if(pos.getData().contains(num)){
               strVal=strVal+pos.getFreq();}
            pos=pos.getNext();}
        return strVal;}
    
    public int binTodec(String tmp){
        int pow=0;
        int sum=0;
        for(int i=tmp.length()-1;i>=0;i--){
            int bin = Integer.parseInt(""+tmp.charAt(i)); 
            if(bin==1){
                sum=sum+(int)Math.pow(2, pow);}
            pow++;}
        return sum;}}
    
    
    public class ArrObj {

    private char alpha = ' ';
    private int freq = 0;

    public ArrObj() {
    }

    public ArrObj(char alpha, int freq) {
        this.alpha = alpha;
        this.freq = freq;
    }

    public char getAlpha() {
        return alpha;
    }

    public void setAlpha(char alpha) {
        this.alpha = alpha;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

}
    
    static ArrObj objArr[];
    public void huff(String strVal){
        
        int arr[]=new int[256];
        for(int i=0;i<arr.length;i++){
            arr[i]=0;}
        
        for(int i=0;i<strVal.length();i++){
            int chVal = strVal.charAt(i);
            arr[chVal]++;}
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                count++;}}
        
        objArr = new ArrObj[count];
        count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                char chVal = (char)i;
                objArr[count] = new ArrObj(chVal,arr[i]);
                count++;}}}
   
    public static void main(String[] args) throws IOException {
    
        
        DLinkedList tmpObjDLL = new DLinkedList();
        Huffman tmpObj = new Huffman();

        File file = new File("thecatlonger.text");
        Scanner scan = new Scanner(file);
        scan = new Scanner(file);
        scan.useDelimiter("\\Z");
        String strVal = scan.next();
        scan.close();
        
        tmpObj.huff(strVal);
        for (ArrObj objArr1 : objArr) {
            String tmp = ""+objArr1.getAlpha();
            tmpObjDLL.insertAtTail(tmp, objArr1.getFreq());}
            tmpObjDLL.buildMinHeap();

        DLinkedList q = new DLinkedList();
        String sti = "";
        DNode newNode = new DNode();
        
        String tmpArr[]=new String[tmpObjDLL.getSize()*2-1];
        int tmpCount=0;
        int keepCount=0;
        while (tmpObjDLL.getSize() > 1) {
            DNode node1 = tmpObjDLL.removeHead();
            DNode node2 = tmpObjDLL.removeHead();
             newNode = new DNode(node1.getData() + node2.getData(), node1.getFreq() + node2.getFreq());
            tmpObjDLL.insertAtTail(newNode.getData(), newNode.getFreq());
            tmpObjDLL.buildMinHeap();
            sti=sti+" "+node1.getData() + " " + node2.getData() ;
            tmpArr[tmpCount]=node1.getData();
            tmpCount++;
            tmpArr[tmpCount]=node2.getData();
            tmpCount++;
            
            q.addHead(node1.getData(), 0);
            q.addHead(node2.getData(), 1);}
            System.out.println("");
        q.addHead(newNode.getData(), 1);
      
        sti=sti+" "+newNode.getData(); 
        System.out.println("");
        tmpArr[tmpCount]=newNode.getData(); 
        PrintWriter print=null;
        print = new PrintWriter(new FileWriter("newCatFile.txt"));
        for (int i=0;i<strVal.length();i++) {
            String tmp = "" + strVal.charAt(i);
            String encode= q.find(tmp);
            print.print(encode);
        }
        print.close();
       
        String array1[];
        array1 = sti.split("");
        int count=0;
        
        String newArr[] = new String[array1.length];
        for(int i=array1.length-1;i>0;i--){
            newArr[count] = array1[i];
            count++;}
        
        System.out.println("");
        String copyArr[]= new String[tmpArr.length];
        for(int i=0;i<copyArr.length;i++){
            copyArr[i]=tmpArr[i];}
        count=0;
 
        for(int i=copyArr.length-1;i>=0;i--){
             tmpArr[count] = copyArr[i];
            count++;}
        System.out.println("");
        
        
        DLinkedList tmpNode = new DLinkedList();
        for(int i=0;i<newArr.length-1;i++){
            tmpNode.insertAtTail(newArr[i], (tmpNode.binTodec(q.find(newArr[i]))));}
        System.out.println("");
     
        file = new File("newCatFile.txt");
        scan = new Scanner(file);
        scan.useDelimiter("\\Z");
        String tmpVal = ""+scan.next().replace("\n", "");
        
        int counter=0;
        
        for(int i=0;i<=tmpVal.length();i++){
            String tmp = tmpVal.substring(counter, i);
            String myTmpStr=tmpNode.nodeAtmyIndex(tmpNode.binTodec(tmp));
            if(!myTmpStr.equals("")){
                System.out.print(myTmpStr+"");
                counter=i;}}}}
