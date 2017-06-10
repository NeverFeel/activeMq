# activemq
<h3>first push</h3>
<h5>1.relevance local repo</h5>
sudo git remote add origin https://github.com/NeverFeel/activemq.git<br>
<h5>2.some problems when pushing</h5>
! [rejected]        master -> master (fetch first)<br>
error: failed to push some refs to 'https://github.com/NeverFeel/activemq.git'<br>
hint: Updates were rejected because the remote contains work that you do<br>
hint: not have locally. This is usually caused by another repository pushing<br>
hint: to the same ref. You may want to first integrate the remote changes<br>
hint: (e.g., 'git pull ...') before pushing again.<br>
hint: See the 'Note about fast-forwards' in 'git push --help' for details.<br>

主要是没有将github中的README.md文件拉下来<br>
执行：git pull --rebase origin master<br>

再执行:sudo git push origin master<br>
