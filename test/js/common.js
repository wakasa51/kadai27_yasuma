// base
$(function() {

});

// 初期状態のオセロの配列の作成
function make_initial_board(number_square, now_board){
  for(var x=0; x<number_square; x++){
    for(var y=0; y<number_square; y++){
      now_board[[x, y]] = 'empty';
    }}

  var initial_stone = number_square / 2;
  now_board[[initial_stone -1, initial_stone -1]] = 'white';
  now_board[[initial_stone, initial_stone -1]] = 'black';
  now_board[[initial_stone -1, initial_stone]] = 'black';
  now_board[[initial_stone, initial_stone]] = 'white';

  return now_board;
}

//配列の中身を元に盤面を描画する関数
function display_board(now_board, player, number_square){
  var db = [];
  // var dbの中に書く描画要素を入れていく
  db.push('<table>');
  for(var y=0; y<number_square; y++){
    db.push('<tr>');
    for(var x=0; x<number_square; x++){
      db.push('<td class="field">');
      if(now_board[[x, y]] != 'empty'){
        db.push('<p class="stone');
        db.push(' ');
        db.push(now_board[[x, y]]);
        db.push('"></p>');
      }else{
        db.push('<p id="#'+x+","+y+'" class="stone empty"></p>');
        // emptyには、idに配列の座標をつける
      }
      db.push('</td>');
    }
    db.push('</tr>');
  }
  db.push('</table>');
  $('#game-board').html(db.join(''));
  // joinで配列のpushの中身を結合しhtmlとして出す
  if(player == "black"){
    $('#now-player').html('次は黒の番です');
  }else{
    $('#now-player').html('次は白の番です');
  }
}

// クリックした場所の隣接地に何が置かれているかを格納する配列
function check_around(now_board, xa, ya){
  var check = [];
  var xb = xa-1;
  var yb = ya-1;
  for(var i=0; i<3; i++){
    for(var j=0; j<3; j++){
      check.push(now_board[[xb, yb]]);
      xb = xb+1;
    }
    yb = yb+1;
    xb = xa-1;
  }
  return check;
}

// クリックした場所の隣接地に応じて移動の変数を割り振る関数
function move_number(i){
  if(i == 0){
    var xv = -2;
    var yv = -2;
  }else if(i == 1){
    var xv = 0;
    var yv = -2;
  }else if(i == 2){
    var xv = 2;
    var yv = -2;
  }else if(i == 3){
    var xv = -2;
    var yv = 0;
  }else if(i == 5){
    var xv = 2;
    var yv = 0;
  }else if(i == 6){
    var xv = -2;
    var yv = 2;
  }else if(i == 7){
    var xv = 0;
    var yv = 2;
  }else if(i == 8){
    var xv = 2;
    var yv = 2;
  }else{
    var xv = 0;
    var yv = 0;
  }
  return[xv, yv];
}

//石をひっくり返す関数
function reverse_stone(xc, yc, xv, yv, player, opponent, now_board, number_square){
  var cc = 0;
  xc = xc - (xv/2);
  yc = yc - (yv/2);
  do{
    now_board[[xc, yc]] = player;
    xc = xc - (xv/2);
    yc = yc - (yv/2);
    if(now_board[[xc, yc]]!=opponent){
      break;
    }
  }while(cc<number_square);
  return now_board;
}

// クリック時に、石を置く場所の配列に色を代入する関数
function put_stone_board(xa, ya, player, now_board){
  now_board[[xa, ya]] = player;
  return now_board;
}

// プレイヤーを変える関数
function player_change(player){
  if(player == "black"){
    player = "white";
  }else{
    player = "black";
  }
  return player;
}

//
function opponent_change(player, opponent){
  if(player== 'black'){
    opponent = 'white';
  }else{
    opponent = 'black';
  }
  return opponent;
}

// 各マスに置いた場合のシミュレーション獲得数
function simulation_get_stone(now_board, number_square, player, opponent){
  var get_stone_count = 0;  //あるマスに置いた時のセル獲得数
  var get_stone_count_all = [[]];  //各マスに置いた時のセル獲得数を全て格納する配列
  for(var i=0; i<number_square; i++){
    for(var j=0; j<number_square; j++){
      var judge = now_board[[j, i]];
      if(judge!='empty'){
        // あるマスの中身が'black'か'white'の場合は置けないので獲得数を0とする
        get_stone_count_all[[j, i]] = 0;
      }else{
        // マスの中身がemptyの時は、隣接地に相手の色があるか確認
        var check = [];
        for(var k=-1; k<2; k++){
          for(var l=-1; l<2; l++){
            check.push(now_board[[j + parseInt(l), i + parseInt(k)]]);
          }
        }
        // 配列の中身を確認。一つでも相手の石が隣接地にあるか調べる。
        if($.inArray(opponent, check)<0){
          // 隣接地に相手の色がなかった場合
          get_stone_count_all[[j, i]] = 0;
        }else{
          // 隣接地に相手の色がある場合は、その先に自分の色があるかチェック
          for(var m=0; m<9; m++){
            if(check[m] == opponent){
              var xz = move_number(m)[0];
              var yz = move_number(m)[1];
              var n = xz + parseInt(j);
              var o = yz + parseInt(i);
              for(var p=0; p<number_square; p++){
                // 先が自分の石だった場合は現在の繰り返し回数を入力
                if(now_board[[n, o]]==player){
                  p = p + 1;
                  if(typeof get_stone_count_all[[j, i]]=="undefined"){
                    get_stone_count_all[[j, i]] = p;
                    break;
                  }else{
                    get_stone_count_all[[j, i]] = get_stone_count_all[[j, i]] + p;
                    break;
                  }
                }else if(now_board[[n, o]]==opponent){
                  n = n + (xz/2);
                  o = o + (yz/2);
                }else{
                  if(typeof get_stone_count_all[[j, i]]=="undefined"){
                    get_stone_count_all[[j, i]] = 0;
                    break;
                  }
                    break;
                }
              }
            }
          }
        }
      }
    }
  }
  return get_stone_count_all;
}

// 最大獲得数を描画し、もし打てる手がなければパスの画面を描画する関数
function get_max_count(get_stone_count_all, number_square){
  var tmp = [];
  for(var i=0; i<number_square; i++){
    for(var j=0; j<number_square; j++){
      tmp.push(get_stone_count_all[[j, i]]);
    }
  }
  var max_get = Math.max.apply(null, tmp);
  if(max_get>0){
    $('#get-count').html('<p class="max-count">次は置いた時に獲得できる最大数は' + max_get + '個です。</p>');
  }else{
    $('#get-count').html('<p class="max-count">置ける場所がありません。パスしてください。</p><button class="pass-btn">パスする</button>');
  }
}

// ゲーム終了を告げる関数
function game_end(now_board, number_square, pass_count){
  var end_check = [];
  for(var i=0; i<number_square; i++){
    for(var j=0; j<number_square; j++){
      end_check.push(now_board[[j, i]]);
    }
  }
  if(pass_count==2){
    var black_get = 0;
    var white_get = 0;
    for(var k=0; k<number_square*number_square; k++){
      if(end_check[k]=='black'){
        black_get = black_get + 1;
      }else{
        white_get = white_get + 1;
      }
    }
  }else if($.inArray('empty', end_check)<0){
    var black_get = 0;
    var white_get = 0;
    for(var k=0; k<number_square*number_square; k++){
      if(end_check[k]=='black'){
        black_get = black_get + 1;
      }else if(end_check[k]=='white'){
        white_get = white_get + 1;
      }
    }
  }
    if(typeof black_get=="undefined" && typeof white_get=="undefined"){

    }else{
    var winner;
    if(black_get==white_get){
      winner = "引き分け！";
    }else if(black_get>white_get){
      winner = "黒の勝ち！";
    }else{
      winner = "白の勝ち！";
    }
    $('#now-player').empty();
    $('#get-count').empty();
    $('#end-game').html('<p class="end-text">黒の獲得数：' + black_get +
     '<br>白の獲得数：' + white_get + '</p><p class="win-text">' + winner +
     '</p><button class="reset-game" onclick="window.location.reload();">リスタート</button>' +
     '<button class="return-top" onclick="location.href=\'./howmany-block.html\'">トップに戻る</button>');
   }
}
