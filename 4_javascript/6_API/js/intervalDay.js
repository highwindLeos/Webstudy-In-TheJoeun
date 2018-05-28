// javascript sorce file
// now.intervalDay(thatDay); 혹은
// thatDay.intervalDay(now);
Date.prototype.intervalDay = function (date){
    if(this > date){ // this 가 뒷날
        interval = this.getTime() - date.getTime();
    } else { // date 가 뒷날
        interval = date.getTime() - this.getTime();
    }
    return Math.floor(interval / ( 1000 * 60 * 60 * 24 )); // 계산된 밀리초를 일수로 계산해서 반환.
};
