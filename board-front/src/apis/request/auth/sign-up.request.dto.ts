export default interface SignUpRequestDto {
    // 필드 지정
    email: string;
    password: string;
    nickname: string;
    telNumber: string;
    address: string;
    addressDetail:string | null;
    agreedPersonal: boolean;
}