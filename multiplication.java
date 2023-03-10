import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class multiplication {
    public static void main(String [] args) {

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "MultiplyNumbers", null, "java/lang/Object", null);

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

            //Double
            mv.visitLdcInsn((Double) 30.45); //LDC instruction
            mv.visitVarInsn(Opcodes.DSTORE, 1); //store in 1
            mv.visitLdcInsn((Double) 10.21); //create new double variable
            mv.visitVarInsn(Opcodes.DSTORE, 3); //store in 3
            mv.visitVarInsn(Opcodes.DLOAD, 1); //load 1 
            mv.visitVarInsn(Opcodes.DLOAD, 3); //load 3
            mv.visitInsn(Opcodes.DMUL); // multiply 1 and 3
            mv.visitVarInsn(Opcodes.DSTORE, 5); //store in 5

            mv.visitFieldInsn(Opcodes.GETSTATIC, "java.lang/System", "out", "Ljava/io/PrintStream;");// PrintStream initialization
            mv.visitVarInsn(Opcodes.DLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);

            //Int
            mv.visitLdcInsn((int) 30); //LDC instruction
            mv.visitVarInsn(Opcodes.ISTORE, 1); //store in 1
            mv.visitLdcInsn((int) 10); //create new int variable
            mv.visitVarInsn(Opcodes.ISTORE, 3); //store in 3
            mv.visitVarInsn(Opcodes.ILOAD, 1); //load 1 
            mv.visitVarInsn(Opcodes.ILOAD, 3); //load 3
            mv.visitInsn(Opcodes.IMUL); // multiply 1 and 3
            mv.visitVarInsn(Opcodes.ISTORE, 5); //store in 5

            mv.visitFieldInsn(Opcodes.GETSTATIC, "java.lang/System", "out", "Ljava/io/PrintStream;");// PrintStream initialization
            mv.visitVarInsn(Opcodes.ILOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

            //Long
            mv.visitLdcInsn((Long) 30.45); //LDC instruction
            mv.visitVarInsn(Opcodes.JSTORE, 1); //store in 1
            mv.visitLdcInsn((Long) 10.21); //create new Long variable
            mv.visitVarInsn(Opcodes.JSTORE, 3); //store in 3
            mv.visitVarInsn(Opcodes.JLOAD, 1); //load 1 
            mv.visitVarInsn(Opcodes.JLOAD, 3); //load 3
            mv.visitInsn(Opcodes.JMUL); // multiply 1 and 3
            mv.visitVarInsn(Opcodes.JSTORE, 5); //store in 5

            mv.visitFieldInsn(Opcodes.GETSTATIC, "java.lang/System", "out", "Ljava/io/PrintStream;");// PrintStream initialization
            mv.visitVarInsn(Opcodes.JLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);

            //Float
            mv.visitLdcInsn((Float) 30.45); //LDC instruction
            mv.visitVarInsn(Opcodes.FSTORE, 1); //store in 1
            mv.visitLdcInsn((Float) 10.21); //create new float variable
            mv.visitVarInsn(Opcodes.FSTORE, 3); //store in 3
            mv.visitVarInsn(Opcodes.FLOAD, 1); //load 1 
            mv.visitVarInsn(Opcodes.FLOAD, 3); //load 3
            mv.visitInsn(Opcodes.FMUL); // multiply 1 and 3
            mv.visitVarInsn(Opcodes.FSTORE, 5); //store in 5

            mv.visitFieldInsn(Opcodes.GETSTATIC, "java.lang/System", "out", "Ljava/io/PrintStream;");// PrintStream initialization
            mv.visitVarInsn(Opcodes.FLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);

            //
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();

        }
        cw.visitEnd();

        byte [] b = cw.toByteArray();
        writeFile(b, "MultiplyNumbers.class");
        System.out.println("Done");
    }
}
