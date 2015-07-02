#version 400 core

in vec3 position;

out vec3 colour;

uniform mat4 translationMatrix;

void main(void) {
	
	gl_Position = vec4(position, 1.0);
	colour = vec3(0.05, 0.05, 0.05);
	
}