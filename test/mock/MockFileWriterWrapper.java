package mock;

import util.FileWriterWrapper;


public class MockFileWriterWrapper extends FileWriterWrapper {
    private String message;
    
    public MockFileWriterWrapper(){
        super(null);
    }
    
    @Override
    public void write(String message){
       this.message = message;
    }
}
