import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class whileLoop {
    public static void main(String [] args) {

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "While", null, "java/lang/Object", null);

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

            Label start = new Label();
            Label end = new Label();

            mv.visitLabel(start);
            mv.visitIntInsn(Opcodes.BIPUSH, 5); //Push value 5 onto stack
            mv.visitVarInsn(Opcodes.ILOAD, 0); //load int i onto stack
            mv.visitJumpInsn(Opcodes.IF_ICMPGT, end); //if variable is greater than 5, jump to end of loop

            mv.visitIincInsn(0,1); //i increments by 1
            mv.visitJumpInsn(Opcodes.GOTO, start); //jumps back to start of loop

            mv.visitLabel(end); //end of loop

            //
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }
        cw.visitEnd();

        byte [] b = cw.toByteArray();
        writeFile(b, "While.class");
        System.out.println("Done");
    }
}

