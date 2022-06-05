public enum EnumSingleton {
    //Здесь определена единственная запись, к которой можно будет обращаться из любой точки кода
    INSTANCE;

    public void doWork() {

        System.out.println("Singleton is working... My unique code: " + INSTANCE.hashCode());
    }
}
