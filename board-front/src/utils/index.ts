// 특정 URL을 받아서 파일로 변환해주는 작업
export const convertUrlToFile = async (url: string) => {
    const response = await fetch(url);
    // 파일 형태로 받기
    const data = await response.blob();
    const extend = url.split('.').pop();
    const fileName = url.split('/').pop();
    const meta = { type: `image/${extend}` };
    
    return new File([data], fileName as string, meta);
};

export const convertUrlsToFile = async (urls: string[]) => {
    const files: File[] = [];
    for (const url of urls) {
        const file = await convertUrlToFile(url);
        files.push(file);
    }
    return files;
};