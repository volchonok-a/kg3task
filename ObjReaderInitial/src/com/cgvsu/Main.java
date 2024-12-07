package com.cgvsu;

import com.cgvsu.model.Model;
import com.cgvsu.objreader.ObjReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static com.cgvsu.model.DeleteVertices.deleteVerticesFromModel;


public class Main {

    public static void main(String[] args) throws IOException {

        Path fileName = Path.of("C:/Users/Anastasiya/Downloads/CGVSU-main3/CGVSU-main/3DModels/CaracalCube/caracal_cube.obj");
        String fileContent = Files.readString(fileName);

        Model model = ObjReader.read(fileContent);

        System.out.println("Vertices: " + model.vertices.size());
        System.out.println("Texture vertices: " + model.textureVertices.size());
        System.out.println("Normals: " + model.normals.size());
        System.out.println("Polygons: " + model.polygons.size());

        ArrayList<Integer> verticesToDelete = new ArrayList<>();

        verticesToDelete.add(0);

        Model newModel = deleteVerticesFromModel(model, verticesToDelete);

        System.out.println();

        System.out.println("Vertices: " + newModel.vertices.size());
        System.out.println("Texture vertices: " + newModel.textureVertices.size());
        System.out.println("Normals: " + newModel.normals.size());
        System.out.println("Polygons: " + newModel.polygons.size());
    }


}
