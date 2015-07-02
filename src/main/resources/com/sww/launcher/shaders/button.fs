#version 400 core

in vec3 colour;

out vec4 outColour;

void main(void) {

	outColour = vec4(colour, 0.3);
	
}