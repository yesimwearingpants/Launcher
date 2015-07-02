package com.sww.launcher.draw.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;

import com.sww.launcher.draw.Model;
import com.sww.launcher.draw.gui.Gui;
import com.sww.launcher.draw.shader.StaticShader;
import com.sww.launcher.util.Maths;

public class Renderer {

    private final float red = 0.0307f;
    private final float green = 0.0154f;
    private final float blue = 0.0794f;
    
	public void prepare() {
		GL11.glClearColor(red, green, blue, 0.0f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}

	public void render(Gui quad, StaticShader shader) {
		Model model = quad.getModel();
		GL30.glBindVertexArray(model.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		Matrix4f trans = Maths.createTransformationMatrix(quad.getPosition(), quad.getRotX(), quad.getRotY(), quad.getScalex(), quad.getScaley());
		shader.loadTranslationMatrix(trans);
		GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
		GL20.glDisableVertexAttribArray(0);
		GL30.glBindVertexArray(0);
	}

}
