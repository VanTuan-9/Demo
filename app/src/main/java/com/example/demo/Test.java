package com.example.demo;


public class Test {

    private final String name = "Son";
    private final Object object = "" ;


    public Test(){

        new SubTest(new SubTest.Listener() {
            @Override
            public void showName() {

            }
        });
    }


    static class SubTest {

        private final Listener listener;

        public SubTest( Listener listener) {
            this.listener = listener;

            listener.showName();
        }

        interface Listener{
            void showName();
        }

        public void tesst1(){

        }
    }
}
