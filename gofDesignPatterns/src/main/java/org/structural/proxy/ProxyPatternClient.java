package org.structural.proxy;

//class that can access the internet actually
public class ProxyPatternClient {

    public static void main(String[] args) {
        OfficeInternetAccess access = new ProxyInternetAccess("Stefanescu Mircea");
        access.grantInternetAccess();
    }
}
