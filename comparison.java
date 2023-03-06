import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class comparison {
    public static void main(String [] args) {
        //Create class
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "CompareNumbers", null, "java/lang/Object", null);

        {
            //constructor
            MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(Opcodes.ALOAD, 0); //loads first variable
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false); //visits method instruction. INVOKESPECIAL in this case
            mv.visitInsn(Opcodes.RETURN);
            mV.visitMaxs(1,1);
            mv.visitEnd();

        }

        {
            //main
            MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;) V", null, null);
            mv.visitCode();

            //Long
            mv.visitVarInsn((Long) 10.0); //Create new long variable
            mv.visitVarInsn(Opcodes.JSTORE, 1); //store in 1
            mv.visitVarInsn((Long) 15.0); //create a second long variable
            mv.visitVarInsn(Opcodes.JSTORE, 3); //store in 3
            mv.visitVarInsn(Opcodes.JLOAD, 1); //load 1 
            mv.visitVarInsn(Opcodes.JLOAD, 3); //load 3
            mv.visitVarInsn(Opcodes.JCMPG); // compares both variabels (if 1 > 3, 1 == 3, and 1 < 3)
            mv.visitVarInsn(Opcodes.JSTORE, 5); //store in 5

            mv.visitFieldInsn(Opcodes.GETSTATIC, "java.lang/System", "out", "Ljava/io/PrintStream;");// PrintStream initialization
            mv.visitVarInsn(Opcodes.JLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);

            //
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }
        cw.visitEnd()

        byte [] b = cw.toByteArray();
        writeFile(b, "CompareNumbers.class");
        System.out.println("Done");
    }
}