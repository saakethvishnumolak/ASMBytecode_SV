import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class declaration {
    public static void main(String [] args) {

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "DeclaringStrings", null, "java/lang/Object", null);

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

            mv.visitLdcInsn("Hello World!") //create string variable
            mv.visitVarInsn(Opcodes.ASTORE, 1); //store in 1
            mv.visitLdcInsn("Good Weather!") //create string variable
            mv.visitVarInsn(Opcodes.ASTORE, 3); //store in 3

            mv.visitFieldInsn(Opcodes.GETSTATIC, "java.lang/System", "out", "Ljava/io/PrintStream;");// PrintStream initialization
            mv.visitVarInsn(Opcodes.ALOAD, 1); //load string in 1
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(A)V", false); //print string stored in 1
            mv.visitVarInsn(Opcodes.ALOAD, 3); //load string in 3
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(A)V", false); //print string stored in 3

            //
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }
        cw.visitEnd();

        byte [] b = cw.toByteArray();
        writeFile(b, "DeclaringStrings.class");
        System.out.println("Done");
        
    }
}
