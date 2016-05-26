lfs_install () {
    # Install git-lfs and pull the data files
    wget https://github.com/github/git-lfs/releases/download/v1.1.0/git-lfs-linux-amd64-1.1.0.tar.gz
    tar -zxvf git-lfs-linux-amd64-1.1.0.tar.gz
    export PATH=`pwd`/git-lfs-1.1.0:$PATH
    git config credential.helper store
    echo "https://baschdl:$GITHUB_TOKEN@github.com" > ~/.git-credentials
    git lfs install
}
echo 'install git lfs'
lfs_install

echo 'git reset'
git reset

echo 'pulling from git-lfs'
git lfs pull

echo "ls-files"
git-lfs ls-files
ls -lah Ausbaustufe_1_Analyse/img/
