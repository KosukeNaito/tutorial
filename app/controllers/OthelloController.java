package controllers;

import play.mvc.*;

import views.html.*;
import othello.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class OthelloController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result othello() {
        return ok(othello.render());
    }

    public Result playerPutStone(){
      String result = request().body().asText();
      System.out.println(result);
      String[] xyAndBoard = result.split(",",0);
      Board board = new Board(xyAndBoard[1]);
      int x = Character.getNumericValue(xyAndBoard[0].charAt(0));
      int y = Character.getNumericValue(xyAndBoard[0].charAt(1));
      //ボードの情報を送って書き換え
      //クリックされたボードのインデックス情報を送って置けるかどうか判定　置けたら操作してボードの情報を返す　置けなかったらエラー返す
      return ok(board.playerPutStone(x,y));
    }

    public Result comPutStone(){
      String result = request().body().asText();
      System.out.println(result);
      Board board = new Board(result);
      return ok(board.comPutStone());
    }

}
