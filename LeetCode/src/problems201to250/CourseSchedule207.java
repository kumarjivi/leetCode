package problems201to250;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/***
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * @author jivi
 *
 */
public class CourseSchedule207 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1,0},{1,2},{0,1}}; 
		System.out.println(canFinish(3, arr));
	}
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] dependencies = new ArrayList[numCourses];
        Set<Integer> visitedSet = new HashSet<Integer>();
        //iterate preReqs and creare the dependency array
        for(int i=0; i<prerequisites.length; i++) {
            int freeCourse = prerequisites[i][1];
            int dependentCourse = prerequisites[i][0];
            if(dependencies[dependentCourse] == null) {
            	dependencies[dependentCourse] = new ArrayList<Integer>();
            }
            dependencies[dependentCourse].add(freeCourse);
        }
        int courseCompletedSoFar = 0;
        while(courseCompletedSoFar < numCourses) {
            //find an independent course(index in dependencies having null or empty list)
            int indepCourse = getIndependentCourse(dependencies, visitedSet);
            //if there is no independent course, means it can't be completed.
            if(indepCourse == -1) {
                return false;
            }
            //remove that independent course from every dependncy.
            removeFromDependencies(dependencies, indepCourse, visitedSet);
            //increment courseCompletedSoFar
            courseCompletedSoFar++;
        }
        return true;
    }
    
    public static void removeFromDependencies(List<Integer>[] dependencies, int course, Set<Integer> visitedSet) {
        visitedSet.add(course);
        for(int i=0; i<dependencies.length; i++) {
            if(dependencies[i] != null && !dependencies[i].isEmpty()) {
                int index = dependencies[i].indexOf(course);
                if(index != -1)
                    dependencies[i].remove(index);
            }
        }
    }
    
    public static int getIndependentCourse(List<Integer>[] dependencies, Set<Integer> visitedSet) {
        for(int i=0; i<dependencies.length; i++) {
            if(visitedSet.contains(i)) {
            	continue;
            }
            if(dependencies[i] == null || dependencies[i].isEmpty()) {
                return i;
            }
        }
        return -1;
    }

}
