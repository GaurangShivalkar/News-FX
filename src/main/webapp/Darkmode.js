    const switchBtn = document.querySelector('.switch input');
    var topNav = document.querySelector('.topnav');
    var menuNav = document.querySelector('#menu-nav');
    var menuTab = document.querySelector('#menu-tab');
    var active = document.querySelector('#active');
    
    var mainDivs = document.querySelectorAll('.main');
    var homeDiv = document.querySelector('.home');
    var leftDivs = document.querySelectorAll('.left');
    var cmtBtn = document.querySelectorAll('.comm');
    
    
    switchBtn.addEventListener('change', function() {
        if (this.checked) {
            topNav.classList.add('dark');
            menuNav.classList.add('dark');
            menuTab.classList.add('dark');
            active.classList.add('dark');
            
            mainDivs.forEach(mainDiv => {
                mainDiv.classList.add('hdark');
            });
            
            homeDiv.classList.add('hdark');
            
            leftDivs.forEach(leftDiv => {
                leftDiv.classList.add('hdark');
            });
            cmtBtn.forEach(cmtBtn => {
            	cmtBtn.classList.add('hdark');
            });
        } else {
            topNav.classList.remove('dark');
            menuNav.classList.remove('dark');
            menuTab.classList.remove('dark');
            active.classList.remove('dark');
            
            mainDivs.forEach(mainDiv => {
                mainDiv.classList.remove('hdark');
            });
            
            homeDiv.classList.remove('hdark');
            
            leftDivs.forEach(leftDiv => {
                leftDiv.classList.remove('hdark');
            });
            cmtBtn.forEach(cmtBtn => {
            	cmtBtn.classList.remove('hdark');
            });
        }
    });