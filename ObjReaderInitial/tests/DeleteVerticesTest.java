import com.cgvsu.math.Vector3f;
import com.cgvsu.model.Model;
import com.cgvsu.model.Polygon;
import com.cgvsu.objreader.ObjReader;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.cgvsu.model.DeleteVertices.deleteVerticesFromModel;
import static org.testng.AssertJUnit.assertEquals;

public class DeleteVerticesTest {

    @Test
    public void testRectangle() {
        Model model = new Model();

        model.vertices.add(new Vector3f(0, 0, 0)); // 0
        model.vertices.add(new Vector3f(1, 0, 0)); // 1
        model.vertices.add(new Vector3f(0, 1, 0)); // 2
        model.vertices.add(new Vector3f(1, 1, 0)); // 3

        ArrayList<Integer> vertexIndices1 = new ArrayList<>(List.of(0, 1, 3, 2));
        Polygon polygon1 = new Polygon();
        polygon1.setVertexIndices(vertexIndices1);
        model.polygons.add(polygon1);

        ArrayList<Integer> verticesToDelete = new ArrayList<>();
        verticesToDelete.add(1);

        deleteVerticesFromModel(model, verticesToDelete);

        assertEquals(3, model.vertices.size());
        assertEquals(0, model.polygons.size());
    }

    @Test
    public void testDeleteVerticesFromCube() {
        Model model = new Model();

        model.vertices.add(new Vector3f(0, 0, 0)); // 0
        model.vertices.add(new Vector3f(1, 0, 0)); // 1
        model.vertices.add(new Vector3f(0, 1, 0)); // 2
        model.vertices.add(new Vector3f(1, 1, 0)); // 3
        model.vertices.add(new Vector3f(0, 0, 1)); // 4
        model.vertices.add(new Vector3f(1, 0, 1)); // 5
        model.vertices.add(new Vector3f(0, 1, 1)); // 6
        model.vertices.add(new Vector3f(1, 1, 1)); // 7

        ArrayList<Integer> vertexIndices1 = new ArrayList<>(List.of(0, 1, 3, 2));
        Polygon polygon1 = new Polygon();
        polygon1.setVertexIndices(vertexIndices1);
        model.polygons.add(polygon1);

        ArrayList<Integer> vertexIndices2 = new ArrayList<>(List.of(4, 5, 7, 6));
        Polygon polygon2 = new Polygon();
        polygon2.setVertexIndices(vertexIndices2);
        model.polygons.add(polygon2);

        ArrayList<Integer> vertexIndices3 = new ArrayList<>(List.of(0, 1, 5, 4));
        Polygon polygon3 = new Polygon();
        polygon3.setVertexIndices(vertexIndices3);
        model.polygons.add(polygon3);

        ArrayList<Integer> vertexIndices4 = new ArrayList<>(List.of(2, 3, 7, 6));
        Polygon polygon4 = new Polygon();
        polygon4.setVertexIndices(vertexIndices4);
        model.polygons.add(polygon4);

        ArrayList<Integer> vertexIndices5 = new ArrayList<>(List.of(0, 2, 6, 4));
        Polygon polygon5 = new Polygon();
        polygon5.setVertexIndices(vertexIndices5);
        model.polygons.add(polygon5);

        ArrayList<Integer> vertexIndices6 = new ArrayList<>(List.of(1, 3, 7, 5));
        Polygon polygon6 = new Polygon();
        polygon6.setVertexIndices(vertexIndices6);
        model.polygons.add(polygon6);
        ArrayList<Integer> verticesToDelete = new ArrayList<>();

        verticesToDelete.add(2);
        verticesToDelete.add(0);

        deleteVerticesFromModel(model, verticesToDelete);

        assertEquals(6, model.vertices.size());
        assertEquals(2, model.polygons.size());
    }

    @Test
    public void testPyramid() {
        Model model = new Model();

        model.vertices.add(new Vector3f(0, 0, 0)); // 0
        model.vertices.add(new Vector3f(1, 0, 0)); // 1
        model.vertices.add(new Vector3f(0, 1, 0)); // 2
        model.vertices.add(new Vector3f(1, 1, 0)); // 3
        model.vertices.add(new Vector3f(0, 0, 1)); // 4

        ArrayList<Integer> vertexIndices1 = new ArrayList<>(List.of(0, 1, 3, 2));
        Polygon polygon1 = new Polygon();
        polygon1.setVertexIndices(vertexIndices1);
        model.polygons.add(polygon1); //нижняя

        ArrayList<Integer> vertexIndices2 = new ArrayList<>(List.of(0, 1, 4));
        Polygon polygon2 = new Polygon();
        polygon2.setVertexIndices(vertexIndices2);
        model.polygons.add(polygon2);

        ArrayList<Integer> vertexIndices3 = new ArrayList<>(List.of(1, 3, 4));
        Polygon polygon3 = new Polygon();
        polygon3.setVertexIndices(vertexIndices3);
        model.polygons.add(polygon3);

        ArrayList<Integer> vertexIndices4 = new ArrayList<>(List.of(2, 3, 4));
        Polygon polygon4 = new Polygon();
        polygon4.setVertexIndices(vertexIndices4);
        model.polygons.add(polygon4);

        ArrayList<Integer> vertexIndices5 = new ArrayList<>(List.of(0, 2, 4));
        Polygon polygon5 = new Polygon();
        polygon5.setVertexIndices(vertexIndices5);
        model.polygons.add(polygon5);

        ArrayList<Integer> verticesToDelete = new ArrayList<>();
        verticesToDelete.add(1);

        deleteVerticesFromModel(model, verticesToDelete);

        assertEquals(4, model.vertices.size());
        assertEquals(2, model.polygons.size());

    }

    @Test
    public void testPyramid2() {
        Model model = new Model();

        model.vertices.add(new Vector3f(0, 0, 0)); // 0
        model.vertices.add(new Vector3f(1, 0, 0)); // 1
        model.vertices.add(new Vector3f(0, 1, 0)); // 2
        model.vertices.add(new Vector3f(1, 1, 0)); // 3
        model.vertices.add(new Vector3f(0, 0, 1)); // 4

        ArrayList<Integer> vertexIndices1 = new ArrayList<>(List.of(0, 1, 3, 2));
        Polygon polygon1 = new Polygon();
        polygon1.setVertexIndices(vertexIndices1);
        model.polygons.add(polygon1); //нижняя

        ArrayList<Integer> vertexIndices2 = new ArrayList<>(List.of(0, 1, 4));
        Polygon polygon2 = new Polygon();
        polygon2.setVertexIndices(vertexIndices2);
        model.polygons.add(polygon2);

        ArrayList<Integer> vertexIndices3 = new ArrayList<>(List.of(1, 3, 4));
        Polygon polygon3 = new Polygon();
        polygon3.setVertexIndices(vertexIndices3);
        model.polygons.add(polygon3);

        ArrayList<Integer> vertexIndices4 = new ArrayList<>(List.of(2, 3, 4));
        Polygon polygon4 = new Polygon();
        polygon4.setVertexIndices(vertexIndices4);
        model.polygons.add(polygon4);

        ArrayList<Integer> vertexIndices5 = new ArrayList<>(List.of(0, 2, 4));
        Polygon polygon5 = new Polygon();
        polygon5.setVertexIndices(vertexIndices5);
        model.polygons.add(polygon5);

        ArrayList<Integer> verticesToDelete = new ArrayList<>();
        verticesToDelete.add(0);
        verticesToDelete.add(1);
        verticesToDelete.add(3);

        deleteVerticesFromModel(model, verticesToDelete);

        assertEquals(2, model.vertices.size());
        assertEquals(0, model.polygons.size());
    }

}
