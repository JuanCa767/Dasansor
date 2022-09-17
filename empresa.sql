-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-09-2022 a las 21:03:54
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empresa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credenciales`
--

CREATE TABLE `credenciales` (
  `usuario` char(30) DEFAULT NULL,
  `password` char(12) DEFAULT NULL,
  `new_pass` char(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `credenciales`
--

INSERT INTO `credenciales` (`usuario`, `password`, `new_pass`) VALUES
('ing2111@yahoo.es', '123456', '123456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejecucion`
--

CREATE TABLE `ejecucion` (
  `Num_orden` int(11) NOT NULL,
  `valor_orden` float DEFAULT NULL,
  `fecha_asignacion` char(15) DEFAULT NULL,
  `actividad` char(40) DEFAULT NULL,
  `nombre_sitio` char(30) DEFAULT NULL,
  `fecha_instalacion` char(15) DEFAULT NULL,
  `fecha_integracion` char(15) DEFAULT NULL,
  `fecha_documentacion` char(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ejecucion`
--

INSERT INTO `ejecucion` (`Num_orden`, `valor_orden`, `fecha_asignacion`, `actividad`, `nombre_sitio`, `fecha_instalacion`, `fecha_integracion`, `fecha_documentacion`) VALUES
(1, 15000000, '2022-09-01', 'MODERNIZACION', 'BOG-CENTRO-3', '2022-09-03', '2022-09-07', '2022-09-04'),
(2, 15000000, '2022-09-05', 'MODERNIZACION', 'BOG-NORTE', '2022-09-07', '2022-09-07', '2022-09-08'),
(3, 16000000, '2022-09-10', 'ADECUACION', 'IBAGUE', '2022-09-11', '2022-09-12', '2022-09-10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informe_cliente`
--

CREATE TABLE `informe_cliente` (
  `ref_cliente` int(11) DEFAULT NULL,
  `fecha_radicacion_cliente` char(15) DEFAULT NULL,
  `Num_orden` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `informe_cliente`
--

INSERT INTO `informe_cliente` (`ref_cliente`, `fecha_radicacion_cliente`, `Num_orden`) VALUES
(11001, '2022-09-01', 1),
(11001, '2022-09-02', 2),
(11002, '2022-09-02', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden_de_compra`
--

CREATE TABLE `orden_de_compra` (
  `num_orden_de_compra` int(11) NOT NULL,
  `fecha_registro` char(15) DEFAULT NULL,
  `Num_orden` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `orden_de_compra`
--

INSERT INTO `orden_de_compra` (`num_orden_de_compra`, `fecha_registro`, `Num_orden`) VALUES
(1, '2022-09-02', 1),
(2, '2022-09-03', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre` char(10) DEFAULT NULL,
  `apellido` char(10) DEFAULT NULL,
  `email` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre`, `apellido`, `email`) VALUES
(10211345, 'andrea', 'camacho', 'acamachob9009@gmail.com'),
(802090011, 'armando', 'varela', 'arvarela22@hotmail.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejecucion`
--
ALTER TABLE `ejecucion`
  ADD PRIMARY KEY (`Num_orden`);

--
-- Indices de la tabla `informe_cliente`
--
ALTER TABLE `informe_cliente`
  ADD KEY `Num_orden` (`Num_orden`);

--
-- Indices de la tabla `orden_de_compra`
--
ALTER TABLE `orden_de_compra`
  ADD PRIMARY KEY (`num_orden_de_compra`),
  ADD KEY `Num_orden` (`Num_orden`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `orden_de_compra`
--
ALTER TABLE `orden_de_compra`
  MODIFY `num_orden_de_compra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `informe_cliente`
--
ALTER TABLE `informe_cliente`
  ADD CONSTRAINT `informe_cliente_ibfk_1` FOREIGN KEY (`Num_orden`) REFERENCES `ejecucion` (`Num_orden`);

--
-- Filtros para la tabla `orden_de_compra`
--
ALTER TABLE `orden_de_compra`
  ADD CONSTRAINT `orden_de_compra_ibfk_1` FOREIGN KEY (`Num_orden`) REFERENCES `ejecucion` (`Num_orden`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
