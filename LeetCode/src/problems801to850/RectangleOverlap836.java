package problems801to850;
/***
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
 * and (x2, y2) are the coordinates of its top-right corner.
 * Two rectangles overlap if the area of their intersection is positive.
 * To be clear, two rectangles that only touch at the corner or edges do not overlap.
 * Given two (axis-aligned) rectangles, return whether they overlap.
 * 
 * @author jivi
 *
 */
public class RectangleOverlap836 {
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int oneLX, oneLY, oneRX, oneRY;
        int twoLX, twoLY, twoRX, twoRY;
        oneLX = rec1[0];
        oneLY = rec1[1];
        oneRX = rec1[2];
        oneRY = rec1[3];
        
        twoLX = rec2[0];
        twoLY = rec2[1];
        twoRX = rec2[2];
        twoRY = rec2[3];
        //if(oneLX > twoRX)
        if(oneLX >= twoRX || twoLX >= oneRX) {
            return false;
        }
    
        if(oneLY >= twoRY || twoLY >= oneRY) {
            return false;
        }
    
        return true;
    }
}
