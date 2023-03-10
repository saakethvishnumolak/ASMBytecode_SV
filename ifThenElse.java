import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class ifThenElse {
    public static void main (String [] args) {

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "IfElse", null, "java/lang/Object", null);

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

            Label else = new Label();
            Label end = new Label();

            mv.visitLdcInsn((Int) 82); //create an integer
            mv.visitVarInsn(Opcodes.ISTORE, 1); //store in 1
            mv.visitIntInsn(Opcodes.BIPUSH, 80); //Push value 5 onto stack
            mv.visitVarInsn(Opcodes.ILOAD, 1); //load 1
            mv.visitJumpInsn(Opcodes.IFLE, else);

            //Print line if true
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java.lang/System", "out", "Ljava/io/PrintStream;");// PrintStream initialization
            mv.visitLDCInsn("You got a good score");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "()V", false); //print above string

            mv.visitJumpInsn(Opcodes.GOTO, end);
            mv.visitLabel(else);

            //Print line if false
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java.lang/System", "out", "Ljava/io/PrintStream;");// PrintStream initialization
            mv.visitLDCInsn("You did not pass. Try again!");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "()V", false); //print above string

            mv.visitLabel(end);

            //
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }
        cw.visitEnd();

        byte [] b = cw.toByteArray();
        writeFile(b, "IfElse.class");
        System.out.println("Done");
    }
}
