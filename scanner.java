import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class scanner {
    public static void main(String [] args) {

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "ScannerInput", null, "java/lang/Object", null);

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


            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;"); // Load scanner

            mv.visitFieldInsn(Opcodes.GETSTATIC, "java.lang/System", "out", "Ljava/io/PrintStream;");// PrintStream initialization
            mv.visitLDCInsn("Enter your age: ");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(A)V", false); // Print above line

            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/InputStream", "read", "()I", false); //Read input

            mv.visitFieldInsn(Opcodes.GETSTATIC, "java.lang/System", "out", "Ljava/io/PrintStream;");// PrintStream initialization
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false); //Printing line

            //
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();

        }
        cw.visitEnd();

        byte[] b = cw.toByteArray();
        writeFile(b, "ScannerInput.class");
        System.out.println("Done");
    }
}