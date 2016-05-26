GIT_LFS_VERSION=v1.2.0

echo "cloning"
git clone https://github.com/github/git-lfs.git

echo "cd into git-lfs"
cd git-lfs

echo "checkout $GIT_LFS_VERSION"
git checkout $GIT_LFS_VERSION

echo "scripts/bootstrap"
script/bootstrap

echo "ls bin"
ls bin

echo "cd back down"
cd ..

echo "resetting travis remote"
git remote set-url origin "git@github.com:hpi-mod-fuenf/main.git"

echo "install"
git-lfs/bin/git-lfs install

echo "pull"
git-lfs/bin/git-lfs pull

#echo "pull again to work around https://github.com/github/git-lfs/issues/904"
#git-lfs/bin/git-lfs pull

echo "ls-files"
git-lfs/bin/git-lfs ls-files
ls -lah ../Ausbaustufe_1_Analyse/img/
